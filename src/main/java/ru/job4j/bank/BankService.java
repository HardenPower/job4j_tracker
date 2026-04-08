package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу модели банковской системы, с операциями:
 * регистрация и удаления пользователей из системы;
 * добавление пользователю банковские счета
 * перевод денежных средств между банковскими счетам
 * @author Alexey B.Harden
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение инфо о пользовательских счетах находится в поле {@code users}
     * это карта (Map) ключ-значение
     * ключ - Объекта класса User, значение - список банковских счетов (объект Account)
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод для добавления пользователя в систему
     * Если пользователь с таким ключом ещё не существует, он добавляется в карту
     * с новым пустым списком счетов иначе не добавляется.
     * @param user пользователь, который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя по номеру паспорта
     * Удаление происходит по совпадению ключа в карте с помощью метода remove
     * @param passport номер паспорта пользователя для удаления
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет банковский счёт пользователю по номеру паспорта.
     * Если пользователь по паспорту существует, из карты получается список его счетов.
     * Счёт добавляется только в том случае, если он ещё не присутствует в списке.
     * Если пользователь не найден, выполнение просто завершается
     * @param passport номер паспорта пользователя
     * @param account объект для добавления нового банк.счета
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountsUser = getAccounts(user);
            if (!accountsUser.contains(account)) {
                accountsUser.add(account);
            }
        }
    }

    /**
     * Метод реализует поиск пользователя в карте по имени паспорта
     * Поиск осуществляется путем перебора всех ключей карты и сравнение с входящим параметром
     * - искомым номером паспорта с помощью метода equals( при реализуемом переопределения метода в классе User)
     * если паспорт найден в карте, возвращаем объект User с данным номером паспорта
     * @param passport номер паспорта пользователя
     * @return User - объект пользователя, найденного в карте
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                result = key;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализует поиск в карте по номеру паспорта пользователя и по номеру его реквизитов банк.счета
     * В случае, если пользователь найден в карте, из списка с объектами Account достается все счета этого пользователя
     * если переданные в  метод реквизиты существуют в списке всех счетов данного пользователя -
     * возвращается объект Account с найденным реквизитом счета
     * @param passport номер паспорта пользователя
     * @param requisite номер реквизита счета
     * @return объекта банк.счета, найденного в карте
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        Account account = null;
        if (user != null) {
            List<Account> accountsUser = getAccounts(user);
            for (Account item : accountsUser) {
                if (item.getRequisite().equals(requisite)) {
                    account = item;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод реализует функционал перевода средств с одного счета на другой
     * Проверяется по паспорту и реквизитам, что аккаунты отправителя и получателя существуют
     * Проверяется баланс отправителя
     * В случае выполнения всех проверок, поле {@code balance} объекта Account у получателя
     * увеличивается на значение {@param amount}, поле {@code balance} объекта Account у отправителя
     * уменьшается на значение {@param amount},
     * @param sourcePassport номер паспорта отправителя
     * @param sourceRequisite реквизиты счета отправителя
     * @param destinationPassport номер паспорта получателя
     * @param destinationRequisite реквизиты счета получателя
     * @param amount необходимая сумма перевода
     * @return результат успеха перевода средств - true/false
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account accSrc = findByRequisite(sourcePassport, sourceRequisite);
        Account accDes = findByRequisite(destinationPassport, destinationRequisite);
        if (accSrc != null && accDes != null && accSrc.getBalance() >= amount) {
            accDes.setBalance(accDes.getBalance() + amount);
            accSrc.setBalance(accSrc.getBalance() - amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод для получаения всех счетов запрашиваемого пользователя
     * ключ - объект user
     * получение списка происходит с помощью метода get карты
     * @param user объект пользователя
     * @return список счетов переданного пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
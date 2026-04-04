package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountsUser = getAccounts(user);
            if (!accountsUser.contains(account)) {
                accountsUser.add(account);
//                users.putIfAbsent(user, accountsUser);
            }
        }
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
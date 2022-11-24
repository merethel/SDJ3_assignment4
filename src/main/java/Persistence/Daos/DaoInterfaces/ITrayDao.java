package Persistence.Daos.DaoInterfaces;

import Shared.Model.Tray;

public interface ITrayDao
    {
        public Tray create(Tray tray);
        public Tray getById(int id);
    }


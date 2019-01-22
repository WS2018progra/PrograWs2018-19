hatEinenStern(ph).
hatZweiSterne(sh).
hatDreiSterne(jh).
hatVierSterne(wh).
hatFuenfSterne(bh).
hatFuenfSterne(fb).

istUnterkunft(ph).
istUnterkunft(sh).
istUnterkunft(jh).
istUnterkunft(wh).
istUnterkunft(bh).
istUnterkunft(fb).

hatEinenSternWeniger(X,Y):-hatFuenfSterne(Y),hatVierSterne(X).
hatEinenSternWeniger(X,Y):-hatVierSterne(Y),hatDreiSterne(X).
hatEinenSternWeniger(X,Y):-hatDreiSterne(Y),hatZweiSterne(X).
hatEinenSternWeniger(X,Y):-hatZweiSterne(Y),hatEinenStern(X).

hatWenigerSterne(U1,U2):-hatEinenSternWeniger(U1,U2).
hatWenigerSterne(U1,U2):-hatEinenSternWeniger(U1,U3),hatWenigerSterne(U3,U2).



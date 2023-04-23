# DIOPHANINE EQUATIONS SOLVER

Data l' equazione Mx - Ny = 1 con M, N coprimi cerchiamo le soluzioni intere.
Per farlo sfruttiamo l' espressione del numero razionale M / N (se M < N) in frazione continua limitata.
Se la profondità è dispari, si ha che M_j N_j-1 - M_j-1 N_j = 1, per cui la soluzione è (N_j-1, M_j-1)
Se la profondità è pari, si ha che M_j N_j-2 - M_j-2 N_j = 1, per cui la soluzione è (N_j-2, M_j-2)
Se M > N, si può risolvere con N / M e invertire quanto detto prima.
Se si vuole la soluzione più vicina all' origine, nel caso M < N si ottiene con quanto detto sopra; se M > N si può risolvere scambiando M ed N e ritornando la soluzione con un meno davanti e le coordinate invertite.
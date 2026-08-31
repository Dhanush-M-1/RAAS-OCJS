#include <bits/stdc++.h>
using namespace std;
int main() {
  int pcount = 1, ncount = 0;
  vector<char> oplist;
  while (true) {
    char op;
    cin >> op;
    switch (op) {
      case '+':
        ++pcount;
        oplist.push_back(op);
        continue;
      case '-':
        ++ncount;
        oplist.push_back(op);
        continue;
      case '?':
        continue;
      case '=':
        goto OUT;
    }
  }
OUT:
  int N;
  cin >> N;
  int pmin = pcount;
  int pmax = pcount * N;
  int nmin = ncount;
  int nmax = ncount * N;
  if (N < pmin - nmax || N > pmax - nmin) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  int ptotal, ntotal;
  if (nmin + N >= pmin) {
    ntotal = nmin;
    ptotal = nmin + N;
  } else {
    ptotal = pmin;
    ntotal = pmin - N;
  }
  if (ncount == 0) ncount = 1;
  int pavg = ptotal / pcount;
  int pfirst = ptotal % pcount;
  int navg = ntotal / ncount;
  int nfirst = ntotal % ncount;
  if (pfirst > 0) {
    cout << pavg + 1;
    --pfirst;
  } else {
    cout << pavg;
  }
  for (auto op : oplist) {
    switch (op) {
      case '+':
        cout << " + ";
        if (pfirst > 0) {
          cout << pavg + 1;
          --pfirst;
        } else
          cout << pavg;
        break;
      case '-':
        cout << " - ";
        if (nfirst > 0) {
          cout << navg + 1;
          --nfirst;
        } else
          cout << navg;
        break;
    }
  }
  cout << " = " << N;
  return 0;
}

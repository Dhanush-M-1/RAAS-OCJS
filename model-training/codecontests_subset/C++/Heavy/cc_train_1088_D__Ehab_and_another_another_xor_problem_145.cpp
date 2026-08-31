#include <bits/stdc++.h>
using namespace std;
int main() {
  bitset<30> a;
  bitset<30> b;
  a.reset();
  b.reset();
  bool bigger = 0;
  cout << "? 0 0" << endl;
  fflush(stdout);
  int aa;
  cin >> aa;
  if (aa == -1) {
    bigger = 1;
  }
  bitset<30> adda;
  bitset<30> addb;
  for (int i = 29; i >= 0; i--) {
    adda[i] = 1;
    addb[i] = 1;
    cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
    fflush(stdout);
    int aa;
    cin >> aa;
    if (aa == -1 && bigger == 0) {
      a[i] = 1;
      b[i] = 0;
      adda[i] = 0;
      addb[i] = 1;
      cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
      fflush(stdout);
      int aa;
      cin >> aa;
      if (aa == -1) {
        bigger = 1;
      }
    } else if (aa == 1 && bigger == 1) {
      a[i] = 0;
      b[i] = 1;
      adda[i] = 1;
      addb[i] = 0;
      cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
      fflush(stdout);
      int aa;
      cin >> aa;
      if (aa == 1) {
        bigger = 0;
      }
    } else if (aa == 1 && bigger == 0) {
      adda[i] = 1;
      addb[i] = 0;
      cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
      fflush(stdout);
      int aa;
      cin >> aa;
      if (aa == 1) {
        a[i] = 0;
        b[i] = 0;
        adda[i] = 0;
        addb[i] = 0;
      } else if (aa == -1) {
        a[i] = 1;
        b[i] = 1;
        adda[i] = 1;
        addb[i] = 1;
      }
    } else if (aa == -1 && bigger == 1) {
      adda[i] = 0;
      addb[i] = 1;
      cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
      fflush(stdout);
      int aa;
      cin >> aa;
      if (aa == -1) {
        a[i] = 0;
        b[i] = 0;
        adda[i] = 0;
        addb[i] = 0;
      } else if (aa == 1) {
        a[i] = 1;
        b[i] = 1;
        adda[i] = 1;
        addb[i] = 1;
      }
    } else if (aa == 0) {
      adda[i] = 0;
      addb[i] = 1;
      cout << "? " << adda.to_ulong() << ' ' << addb.to_ulong() << endl;
      fflush(stdout);
      int aa;
      cin >> aa;
      if (aa == -1) {
        a[i] = 0;
        b[i] = 0;
        adda[i] = 0;
        addb[i] = 0;
      } else if (aa == 1) {
        a[i] = 1;
        b[i] = 1;
        adda[i] = 1;
        addb[i] = 1;
      }
    }
  }
  cout << "! " << a.to_ulong() << ' ' << b.to_ulong() << endl;
  fflush(stdout);
}

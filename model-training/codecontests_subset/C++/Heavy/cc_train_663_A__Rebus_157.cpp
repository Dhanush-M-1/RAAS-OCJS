#include <bits/stdc++.h>
using namespace std;
vector<long long> negat, posit;
long long stoi(string s, long long posisi) {
  long long ret = 0, i, len;
  len = s.length();
  for (i = posisi; i < len; ++i) {
    ret = ret * 10;
    ret += s[i] - '0';
  }
  return ret;
}
int main() {
  long long i, len, jmlpos = 1, jmlneg = 0, har, n, posisi, it1 = 0, it2 = 0, l,
                    r, mid, piv;
  bool last = 0;
  string st;
  getline(cin, st);
  len = st.length();
  for (i = 0; i < len; ++i) {
    if (st[i] == '+') {
      jmlpos++;
    } else if (st[i] == '-') {
      jmlneg++;
    }
    if (st[i] == '=') {
      break;
    }
  }
  posisi = i + 2;
  n = stoi(st, posisi);
  for (i = 0; i < jmlpos; ++i) {
    posit.push_back(1);
  }
  for (i = 0; i < jmlneg; ++i) {
    negat.push_back(1);
  }
  if (jmlpos - jmlneg == n) {
    last = 0;
    cout << "Possible" << endl;
    for (i = 0; i < len; ++i) {
      if (st[i] == '?') {
        if (last == 0) {
          cout << posit[it1];
          it1++;
        } else if (last == 1) {
          cout << negat[it2];
          it2++;
        }
      } else if (st[i] == '+') {
        last = 0;
        cout << st[i];
      } else if (st[i] == '-') {
        last = 1;
        cout << st[i];
      } else
        cout << st[i];
    }
    cout << endl;
  } else if (jmlpos - jmlneg > n) {
    piv = jmlpos - jmlneg;
    for (i = 0; i < negat.size(); ++i) {
      l = 0;
      r = n - 1;
      while (l <= r) {
        mid = (l + r) / 2;
        if (piv - mid >= n) {
          l = mid + 1;
        } else
          r = mid - 1;
      }
      piv = piv - (l - 1);
      negat[i] = l;
    }
    if (piv == n) {
      last = 0;
      cout << "Possible" << endl;
      for (i = 0; i < len; ++i) {
        if (st[i] == '?') {
          if (last == 0) {
            cout << posit[it1];
            it1++;
          } else if (last == 1) {
            cout << negat[it2];
            it2++;
          }
        } else if (st[i] == '+') {
          last = 0;
          cout << st[i];
        } else if (st[i] == '-') {
          last = 1;
          cout << st[i];
        } else
          cout << st[i];
      }
      cout << endl;
    } else
      cout << "Impossible" << endl;
  } else if (jmlpos - jmlneg < n) {
    piv = jmlpos - jmlneg;
    for (i = 0; i < posit.size(); ++i) {
      l = 0;
      r = n - 1;
      while (l <= r) {
        mid = (l + r) / 2;
        if (piv + mid <= n) {
          l = mid + 1;
        } else
          r = mid - 1;
      }
      piv = piv + (l - 1);
      posit[i] = l;
    }
    if (piv == n) {
      last = 0;
      cout << "Possible" << endl;
      for (i = 0; i < len; ++i) {
        if (st[i] == '?') {
          if (last == 0) {
            cout << posit[it1];
            it1++;
          } else if (last == 1) {
            cout << negat[it2];
            it2++;
          }
        } else if (st[i] == '+') {
          last = 0;
          cout << st[i];
        } else if (st[i] == '-') {
          last = 1;
          cout << st[i];
        } else
          cout << st[i];
      }
      cout << endl;
    } else
      cout << "Impossible" << endl;
  }
}

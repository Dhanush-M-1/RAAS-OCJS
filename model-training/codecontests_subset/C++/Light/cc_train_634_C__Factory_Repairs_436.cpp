#include <bits/stdc++.h>
using namespace std;
const int SIZE = 200009;
long long int table1[SIZE];
long long int table2[SIZE];
long long int now[SIZE];
int n, k, q;
long long int a, b;
void update(long long int table[], int idx, long long int v) {
  while (idx <= n) {
    table[idx] += v;
    idx += idx & -idx;
  }
}
long long int query(long long int table[], int idx) {
  long long int ret = 0;
  while (idx > 0) {
    ret += table[idx];
    idx -= idx & -idx;
  }
  return ret;
}
int main() {
  cin >> n >> k >> a >> b >> q;
  while (q--) {
    int t;
    cin >> t;
    if (t == 1) {
      int dd, aa;
      cin >> dd >> aa;
      update(table1, dd, min(aa + now[dd], b) - min(now[dd], b));
      update(table2, dd, min(aa + now[dd], a) - min(now[dd], a));
      now[dd] += aa;
    } else {
      int p;
      cin >> p;
      cout << query(table1, p - 1) + query(table2, n) - query(table2, p + k - 1)
           << '\n';
    }
  }
}

#include <bits/stdc++.h>
using namespace std;
long long before[200005], after[200005];
void update1(int idx, long long val) {
  while (idx <= 200000) {
    before[idx] += val;
    idx += (idx & -idx);
  }
}
void update2(int idx, long long val) {
  while (idx <= 200000) {
    after[idx] += val;
    idx += (idx & -idx);
  }
}
long long query1(int idx) {
  long long res = 0;
  while (idx > 0) {
    res += before[idx];
    idx -= (idx & -idx);
  }
  return res;
}
long long query2(int idx) {
  long long res = 0;
  while (idx > 0) {
    res += after[idx];
    idx -= (idx & -idx);
  }
  return res;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int n, k, q;
  long long a, b;
  cin >> n >> k >> a >> b >> q;
  for (int i = 0; i < q; i++) {
    int ch;
    cin >> ch;
    if (ch == 1) {
      int d;
      long long val;
      cin >> d >> val;
      long long temp = query1(d) - query1(d - 1);
      if (temp + val <= b)
        update1(d, val);
      else
        update1(d, b - temp);
      long long temp2 = query2(d) - query2(d - 1);
      if (temp2 + val <= a)
        update2(d, val);
      else
        update2(d, a - temp2);
    } else {
      int d;
      cin >> d;
      cout << query1(d - 1) + query2(200000) - query2(d + k - 1) << "\n";
    }
  }
  return 0;
}

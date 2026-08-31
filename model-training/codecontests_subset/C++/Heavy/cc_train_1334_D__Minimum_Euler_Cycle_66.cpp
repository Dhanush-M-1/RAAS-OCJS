#include <bits/stdc++.h>
#pragma gcc optimize("O3")
#pragma gcc optimize("Ofast")
using namespace std;
long long n, l, r;
long long i, j, t;
void nx() {
  j++;
  if (j == n + 1) {
    i++;
    j = i + 1;
  }
}
void print() {
  if (!t) {
    cout << i << " ";
  } else {
    cout << j << " ";
    nx();
  }
  t ^= 1;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(0);
  int T;
  cin >> T;
  while (T--) {
    int k = 0;
    cin >> n >> l >> r;
    if (r == n * (n - 1) + 1) {
      r--;
      k = 1;
    }
    long long cnt = 1;
    for (i = 1; i <= n && cnt + (n - i) * 2 < l; i++) {
      cnt += (n - i) * 2;
    }
    j = i + 1;
    while (cnt + 2 <= l) {
      cnt += 2;
      j++;
    }
    t = (l - cnt) % 2;
    for (int z = 1; z <= r - l + 1; z++) {
      print();
    }
    if (k)
      cout << 1 << '\n';
    else
      cout << '\n';
  }
}

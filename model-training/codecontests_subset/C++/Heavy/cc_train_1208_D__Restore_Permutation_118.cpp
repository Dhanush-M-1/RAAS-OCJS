#include <bits/stdc++.h>
using namespace std;
int ans[200005], n;
long long a[200005], aib[200005];
inline void Update(int p, int val) {
  while (p <= n) {
    aib[p] += val;
    p += p & (-p);
  }
}
inline long long Sum(int p) {
  long long s = 0;
  while (p >= 1) {
    s += aib[p];
    p -= p & (-p);
  }
  return s;
}
int main() {
  int left, right, mid, poz;
  cin >> n;
  for (int i = 1; i <= n; i++) {
    cin >> a[i];
    Update(i, i);
  }
  for (int i = n; i >= 1; i--) {
    left = 1;
    right = n;
    while (left <= right) {
      mid = (left + right) / 2;
      if (Sum(mid) > a[i]) {
        poz = mid;
        right = mid - 1;
      } else
        left = mid + 1;
    }
    ans[i] = poz;
    Update(poz, -poz);
  }
  for (int i = 1; i <= n; i++) cout << ans[i] << " ";
}

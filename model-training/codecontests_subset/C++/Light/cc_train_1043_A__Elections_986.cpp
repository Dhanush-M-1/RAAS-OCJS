#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
long long n, a[N];
long long sum, mx;
int main() {
  ios::sync_with_stdio(0), cin.tie(0);
  cin >> n;
  for (int i = 0; i < n; i++) {
    long long b;
    cin >> b;
    sum += b;
    mx = max(mx, b);
  }
  sum *= 2;
  sum /= n;
  sum++;
  cout << max(sum, mx);
}

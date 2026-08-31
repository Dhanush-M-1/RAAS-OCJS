#include <bits/stdc++.h>
using namespace std;
clock_t T;
constexpr auto EPS = 1e-7;
const int mod = (int)1e9 + 7;
int dxn[] = {-1, -2, -2, -1, 1, 2, 2, 1};
int dyn[] = {-2, -1, 1, 2, 2, 1, -1, -2};
int dx[] = {0, 0, 1, -1, 1, 1, -1, -1};
int dy[] = {1, -1, 0, 0, 1, -1, 1, -1};
long long gcd(long long a, long long b) { return (a) ? gcd(b % a, a) : b; }
long long lcm(long long a, long long b) { return (a * b) / gcd(a, b); }
void nGu() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
}
int main() {
  nGu();
  int n;
  cin >> n;
  map<int, int> mp, mp1, mp2;
  for (int i = 0; i < n; i++) {
    int x;
    cin >> x;
    mp[x]++;
  }
  for (int i = 0; i < n - 1; i++) {
    int x;
    cin >> x;
    mp1[x]++;
  }
  for (int i = 0; i < n - 2; i++) {
    int x;
    cin >> x;
    mp2[x]++;
  }
  for (auto it : mp)
    if (mp1[it.first] != it.second) {
      cout << it.first << "\n";
      break;
    }
  for (auto it : mp1)
    if (mp2[it.first] != it.second) {
      cout << it.first << "\n";
      break;
    }
}

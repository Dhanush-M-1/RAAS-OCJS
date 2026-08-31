#include <bits/stdc++.h>
using namespace std;
double pi = 3.14159265358979323846;
bool sortbysec(const pair<long long int, long long int> &a,
               const pair<long long int, long long int> &b) {
  if (a.first == b.first) return (a.second < b.second);
  return (a.first < b.first);
}
long long int fpower(long long int x, long long int y) {
  long long int ans = 1;
  while (y) {
    if (y & 1)
      ans = ans * x, y--;
    else
      x *= x, y /= 2;
  }
  return ans;
}
long long int myXOR(long long int x, long long int y) {
  return (x | y) & (~x | ~y);
}
bool prime(long long int x) {
  if (x == 1) return 0;
  for (long long int i = 2; i * i <= x; i++) {
    if (x % i == 0) return 0;
  }
  return 1;
}
long long int gcd(long long int x, long long int y) {
  if (x == 0) return y;
  return gcd(y % x, x);
}
void primefactor(set<long long int> &s, long long int x) {
  for (long long int i = 2; i * i <= x; i++) {
    if (x % i == 0) {
      s.insert({i, x / i});
    }
  }
}
int count(string s, string s1, int n, int m, int sum) {
  if (n == 0 || m == 0) return 0;
  if (s[n - 1] == s1[m - 1])
    sum = max(sum + 1, count(s, s1, n - 1, m - 1, sum + 1));
  else
    sum = max(sum, max(count(s, s1, n - 1, m, 0), count(s, s1, n, m - 1, 0)));
  return sum;
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  ;
  int k;
  cin >> k;
  while (k--) {
    int n, x;
    cin >> n;
    vector<int> v;
    for (int i = 0; i < n; i++) {
      cin >> x;
      v.push_back(x);
    }
    int flag = 0;
    int l = 0, r, i = n - 1;
    for (r = 1; r < i; r++) {
      if (v[i] >= v[l] + v[r]) {
        flag = 1;
        break;
      }
    }
    if (flag) {
      cout << l + 1 << " ";
      cout << r + 1 << " ";
      cout << i + 1 << "\n";
    } else
      cout << -1 << "\n";
  }
}

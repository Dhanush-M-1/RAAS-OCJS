#include <bits/stdc++.h>
using namespace std;
int INF = (int)1e9;
long long INFINF = (long long)1e18 + 10;
const long double PI = 3.14159265358979323846;
long long powermodm(long long x, long long n, long long mod) {
  long long result = 1;
  while (n > 0) {
    if (n % 2 == 1) result = (result * x) % mod;
    x = (x * x) % mod;
    n = n / 2;
  }
  return result;
}
long long GCD(long long, long long);
long long LCM(long long, long long);
long long power(int, int);
long long choose(long long, long long);
int ones(long long);
void extendedEuclid(long long, long long);
long long MMI(long long, long long);
void fastscan(int &);
set<int> adj[200005];
vector<int> degree(200005);
vector<int> a1(200005);
vector<int> b1(200005);
vector<pair<int, int> > pair1;
set<pair<int, int> > set1;
vector<int> vis(200005);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int n, m, k;
  cin >> n >> m >> k;
  vector<int> ans;
  for (long long i = 0; i < m; i++) {
    cin >> a1[i] >> b1[i];
    degree[a1[i]]++;
    degree[b1[i]]++;
    adj[a1[i]].insert(b1[i]);
    adj[b1[i]].insert(a1[i]);
  }
  for (long long i = 0; i < n; i++) {
    set1.insert({degree[i + 1], i + 1});
  }
  for (int i = m - 1; i >= 0; i--) {
    while (!set1.empty()) {
      pair<int, int> temppair;
      temppair = *set1.begin();
      if (temppair.first < k) {
        int temp = temppair.second;
        vis[temp] = 1;
        degree[temp]--;
        set1.erase(temppair);
        for (auto k = adj[temp].begin(); k != adj[temp].end(); k++) {
          set1.erase({degree[*k], *k});
          degree[*k]--;
          if (vis[*k] == 0) {
            set1.insert({degree[*k], *k});
          }
        }
        adj[temp].clear();
      } else {
        break;
      }
    }
    ans.push_back(set1.size());
    set1.erase({degree[a1[i]], a1[i]});
    set1.erase({degree[b1[i]], b1[i]});
    adj[a1[i]].erase(b1[i]);
    adj[b1[i]].erase(a1[i]);
    if (vis[a1[i]] == 0) {
      degree[b1[i]]--;
    }
    if (vis[b1[i]] == 0) {
      degree[a1[i]]--;
    }
    if (vis[a1[i]] == 0) {
      set1.insert({degree[a1[i]], a1[i]});
    }
    if (vis[b1[i]] == 0) {
      set1.insert({degree[b1[i]], b1[i]});
    }
  }
  reverse(ans.begin(), ans.end());
  for (long long i = 0; i < ans.size(); i++) {
    cout << ans[i] << endl;
  }
  return 0;
}
long long GCD(long long a, long long b) {
  if (b == 0)
    return a;
  else
    return GCD(b, a % b);
}
long long LCM(long long a, long long b) {
  return (max(a, b) / GCD(a, b)) * min(a, b);
}
long long power(int a, int n) {
  unsigned long long int result = 1, x = a;
  while (n > 0) {
    if (n % 2 == 1) result = result * x;
    x = x * x;
    n = n / 2;
  }
  return result;
}
long long choose(long long n, long long k) {
  if (k == 0) return 1;
  return (n * choose(n - 1, k - 1)) / k;
}
int ones(long long n) {
  int c = 0;
  while (n) {
    n = n & (n - 1);
    c++;
  }
  return c;
}
long long d, x, y;
void extendedEuclid(long long A, long long B) {
  if (B == 0) {
    d = A;
    x = 1;
    y = 0;
  } else {
    extendedEuclid(B, A % B);
    int temp = x;
    x = y;
    y = temp - (A / B) * y;
  }
}
long long MMI(long long a, long long p) {
  extendedEuclid(a, p);
  if (d == 1 && p != 1)
    return ((x % p) + p) % p;
  else
    return -1;
}
void fastscan(int &number) {
  bool negative = false;
  register int c;
  number = 0;
  c = getchar();
  if (c == '-') {
    negative = true;
    c = getchar();
  }
  for (; (c > 47 && c < 58); c = getchar()) number = number * 10 + c - 48;
  if (negative) number *= -1;
}

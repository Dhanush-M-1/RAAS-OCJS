#include <bits/stdc++.h>
using namespace std;
const int INF = 1e9;
ifstream fin("input.txt");
ofstream fout("output.txt");
long long fast_exp(long long base, long long exp) {
  long long res = 1;
  while (exp > 0) {
    if (exp % 2 == 1) res = (res * base) % 1000000007;
    base = (base * base) % 1000000007;
    exp /= 2;
  }
  return res % 1000000007;
}
int palindromecheck(string s) {
  int n = s.size();
  for (int i = 0; i < n / 2; ++i) {
    if (s[i] != s[n - i - 1]) {
      return 0;
    }
  }
  return 1;
}
int gcd(int a, int b) {
  while (a && b) a > b ? a %= b : b %= a;
  return a + b;
}
int val(char c) {
  if (c >= '0' && c <= '9')
    return (int)c - '0';
  else
    return (int)c - 'A' + 10;
}
long long pows(int a, int b) {
  long long res = 1;
  for (int i = 0; i < b; ++i) {
    res *= a;
  }
  return res;
}
long long logx(long long base, long long num) {
  int cnt = 0;
  while (num != 1) {
    num /= base;
    ++cnt;
  }
  return cnt;
}
long long divisibles(long long a, long long b, long long m) {
  if (a % m == 0)
    return (b / m) - (a / m) + 1;
  else
    return (b / m) - (a / m);
}
string bitstring(int n, int size) {
  string s;
  while (n) {
    s += (n % 2) + '0';
    n /= 2;
  }
  while (s.size() < size) {
    s += '0';
  }
  reverse(s.begin(), s.end());
  return s;
}
vector<int> root(200001, 0);
vector<int> size(200001, 1);
int find(int x) {
  while (x != root[x]) x = root[x];
  return x;
}
bool same(int a, int b) { return find(a) == find(b); }
void unite(int a, int b) {
  a = find(a);
  b = find(b);
  if (size[a] < size[b]) swap(a, b);
  size[a] += size[b];
  root[b] = a;
}
vector<int> vis(200001, 0);
vector<int> adj[200001];
int main() {
  std::ios::sync_with_stdio(false);
  int t;
  cin >> t;
  while (t--) {
    int n;
    long long l, r;
    cin >> n >> l >> r;
    vector<long long> vec(n + 1);
    long long sum = 0;
    int j = 1;
    for (int i = n; i >= 1; --i) {
      sum += (i - 1) * 2;
      vec[j] = sum;
      if (i == 1) ++vec[j];
      ++j;
    }
    long long idxl = lower_bound(vec.begin(), vec.end(), l) - vec.begin();
    long long idxr = lower_bound(vec.begin(), vec.end(), r) - vec.begin();
    if (vec[idxl] > l && idxl > 1) --idxl;
    vector<pair<long long, long long>> ans;
    int temp = vec[idxl];
    if (idxl == 1) temp = 1;
    long long start;
    if (idxl != 1) start = vec[idxl - 1] + 1;
    for (int i = idxl; i <= idxr; ++i) {
      for (int j = i + 1; j <= n; ++j) {
        ans.push_back(make_pair(i, start++));
        ans.push_back(make_pair(j, start++));
      }
      if (i + 1 > n) {
        ans.push_back(make_pair(1, start));
      }
    }
    long long begin;
    if (idxl == 1) {
      begin = l - 1;
    } else {
      for (int i = 0; i < ans.size(); ++i) {
        if (ans[i].second == l) {
          begin = i;
          break;
        }
      }
    }
    for (int i = begin; i <= begin + (r - l); ++i) cout << ans[i].first << " ";
    cout << "\n";
  }
}

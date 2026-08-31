#include <bits/stdc++.h>
using namespace std;
using vl = vector<long long>;
using vs = vector<string>;
using vvl = vector<vector<long long>>;
const long long INF = 1LL << 60;
template <class T>
bool chmax(T &a, const T &b) {
  if (a < b) {
    a = b;
    return 1;
  }
  return 0;
}
template <class T>
bool chmin(T &a, const T &b) {
  if (b < a) {
    a = b;
    return 1;
  }
  return 0;
}
long long gcd(long long a, long long b) { return b ? gcd(b, a % b) : a; }
long long lcm(long long a, long long b) { return a / gcd(a, b) * b; }
bool compare(pair<long long, long long> a, pair<long long, long long> b) {
  if (a.first != b.first) {
    return a.first < b.first;
  } else {
    return a.second < b.second;
  }
}
bool In_map(long long y, long long x, long long h, long long w) {
  if (y < 0 || x < 0 || y >= h || x >= w) {
    return 0;
  } else {
    return 1;
  }
}
void print(vector<long long> a) {
  for (int i = 0; i < (a.size()); i++) {
    if (i == a.size() - 1) {
      cout << a[i] << endl;
    } else {
      cout << a[i] << " ";
    }
  }
}
const vector<long long> dx{1, 0, -1, 0};
const vector<long long> dy{0, 1, 0, -1};
void Main() {
  long long n, k;
  cin >> n >> k;
  vl a, b, ab;
  for (int i = 0; i < (n); i++) {
    long long t, A, B;
    cin >> t >> A >> B;
    if (A == 1 && B == 1) {
      ab.push_back(t);
    } else if (A == 1) {
      a.push_back(t);
    } else if (B == 1) {
      b.push_back(t);
    }
  }
  sort(ab.begin(), ab.end());
  sort(a.begin(), a.end());
  sort(b.begin(), b.end());
  if (ab.size() + a.size() < k || ab.size() + b.size() < k) {
    cout << -1 << endl;
    return;
  }
  long long ans = INF;
  vl suma(a.size() + 1), sumb(b.size() + 1), sumab(ab.size() + 1);
  for (int i = 0; i < (a.size()); i++) {
    suma[i + 1] = suma[i] + a[i];
  }
  for (int i = 0; i < (b.size()); i++) {
    sumb[i + 1] = sumb[i] + b[i];
  }
  for (int i = 0; i < (ab.size()); i++) {
    sumab[i + 1] = sumab[i] + ab[i];
  }
  long long idx1 = min(k, (long long)ab.size());
  long long idx2 = k - idx1;
  while (1) {
    if (idx1 < 0 || idx2 > min(a.size(), b.size())) {
      break;
    }
    chmin(ans, sumab[idx1] + suma[idx2] + sumb[idx2]);
    idx1--;
    idx2++;
  }
  cout << ans << endl;
  return;
}
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  int t = 1;
  while (t--) {
    Main();
  }
  return 0;
}

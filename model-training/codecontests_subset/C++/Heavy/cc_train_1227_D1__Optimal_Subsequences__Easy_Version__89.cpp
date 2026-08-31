#include <bits/stdc++.h>
using namespace std;
long long N = 200000;
vector<bool> visited(N + 1, false);
bool isprime(long long x) {
  for (long long i = 2; i <= sqrt(x); i++) {
    if (x % i == 0) return false;
  }
  return true;
}
void findfact(long long x, map<long long, vector<long long>>& m) {
  for (long long i = 3; i * i <= x; i += 2) {
    if (x % i == 0) {
      if (i == x / i)
        m[x].push_back(i);
      else {
        m[x].push_back(i);
        m[x].push_back(x / i);
      }
      break;
    }
  }
  return;
}
struct cmp {
  bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.first > b.first)
      return false;
    else if (a.first < b.first)
      return true;
    if (a.second < b.second) return false;
    return true;
  }
};
bool isPalindrome(string t) {
  long long st = 0;
  long long end = t.size() - 1;
  while (st <= end) {
    if (t[st] != t[end]) return false;
    st++;
    end--;
  }
  return true;
}
long long gcd(long long a, long long b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
bool pow2(long long x) { return x && (!(x & (x - 1))); }
unsigned long long factorial(unsigned long long n) {
  return (n == 1 || n == 0) ? 1 : n * factorial(n - 1);
}
unsigned long long binomialCoeff(unsigned long long n, unsigned long long k) {
  unsigned long long res = 1;
  if (k > n - k) k = n - k;
  for (unsigned long long i = 0; i < k; ++i) {
    res *= (n - i);
    res /= (i + 1);
  }
  return res;
}
vector<long long> hp;
void primeFactors(long long n) {
  while (n % 2 == 0) {
    hp.push_back(2);
    n = n / 2;
  }
  for (int i = 3; i <= sqrt(n); i = i + 2) {
    while (n % i == 0) {
      hp.push_back(i);
      n = n / i;
    }
  }
  if (n > 2) hp.push_back(n);
}
long long minFlipsMonoIncr(string S) {
  int flip = 0;
  int ones = 0;
  bool flag = false;
  for (int i = 0; i < S.size(); i++) {
    if (S[i] - '0' == 1) flag = true;
    if (flag && S[i] - '0' == 0)
      flip++;
    else if (S[i] == '1')
      ones++;
    if (flip > ones) flip = ones;
  }
  return flip;
}
void dfs() {}
int main() {
  ios_base::sync_with_stdio(0);
  long long n;
  cin >> n;
  vector<long long> arr(n + 1);
  for (long long i = 1; i <= n; i++) cin >> arr[i];
  long long m;
  cin >> m;
  while (m--) {
    long long k, pos;
    cin >> k >> pos;
    priority_queue<pair<long long, long long>,
                   vector<pair<long long, long long>>, cmp>
        pq;
    for (long long i = 1; i <= n; i++) pq.push(make_pair(arr[i], i));
    vector<long long> temp(n + 1, -1);
    while (k--) {
      temp[pq.top().second] = pq.top().first;
      pq.pop();
    }
    long long ele = 0;
    long long i;
    for (i = 1; i <= n; i++) {
      if (temp[i] == -1)
        continue;
      else
        ele++;
      if (ele == pos) break;
    }
    cout << temp[i] << "\n";
  }
}

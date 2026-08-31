#include <bits/stdc++.h>
const double eps = 1e-10;
const float epsf = 1e-6;
using namespace std;
inline long long int __gcd(long long int a, long long int b) {
  if (a == 0 || b == 0) {
    return max(a, b);
  }
  long long int tempa, tempb;
  while (1) {
    if (a % b == 0)
      return b;
    else {
      tempa = a;
      tempb = b;
      a = tempb;
      b = tempa % tempb;
    }
  }
}
inline int compfloat(float& x, float& y) {
  if (fabs(x - y) < epsf)
    return 0;
  else if (x - y > 0)
    return 1;
  return -1;
}
inline int compdouble(double x, double y) {
  if (fabs(x - y) < eps)
    return 0;
  else if (x - y > 0)
    return 1;
  else
    return -1;
}
bool prime(long long int k) {
  for (long long int i = 2; i * i <= k; i++)
    if (k % i == 0) {
      return false;
    }
  return true;
}
void pdash(int n = 1) {
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < 30; j++) {
      cout << "-";
    }
    cout << "\n";
  }
}
long long int power(long long int x, long long int y) {
  long long int result = 1;
  while (y > 0) {
    if (y & 1) {
      result = (result * x);
    }
    y = y >> 1;
    x = (x * x);
  }
  return result;
}
long long int power(long long int x, long long int y, long long int z) {
  long long int result = 1;
  x = x % z;
  while (y > 0) {
    if (y & 1) {
      result = (result * x) % z;
    }
    y = y >> 1;
    x = (x * x) % z;
  }
  return result;
}
long long int modInverse(long long int n, long long int p) {
  return power(n, p - 2, p);
}
long long int nCrF(long long int n, long long int r, long long int p) {
  if (r == 0) return 1;
  long long int f[n + 1];
  f[0] = 1;
  for (long long int i = 1; i <= n; i++) f[i] = f[i - 1] * i % p;
  return (f[n] * modInverse(f[r], p) % p * modInverse(f[n - r], p) % p) % p;
}
void cordinate_compression(vector<int>& v) {
  vector<int> p = v;
  sort(p.begin(), p.end());
  p.erase(unique(p.begin(), p.end()), p.end());
  for (int i = 0; i < (int)((v).size()); i++)
    v[i] = (int)(lower_bound(p.begin(), p.end(), v[i]) - p.begin());
}
void solve() {
  string str;
  long long int n = 0;
  getline(cin, str);
  string ans = "p";
  long long int pos, neg;
  pos = 1;
  neg = 0;
  for (int i = 0; i < (int)((str).size()); i += 4) {
    if (str[i + 2] == '=') {
      n = stoi(string(str.begin() + (i + 4), str.end()));
      break;
    } else {
      if (str[i + 2] == '+') {
        ans += "p";
        pos++;
      } else {
        ans += "n";
        neg++;
      }
    }
  }
  long long int lambda = (n - (pos - neg));
  vector<long long int> positive(pos, 1);
  vector<long long int> negative(neg, 1);
  if (lambda < -neg * (n - 1) or lambda > pos * (n - 1)) {
    cout << "Impossible\n";
    return;
  }
  if (lambda > 0) {
    for (int i = 0; i < (int)((positive).size()) and lambda; i++) {
      long long int a = min(lambda, n - 1);
      positive[i] += a;
      lambda -= a;
    }
  }
  if (lambda < 0) {
    lambda *= -1;
    for (int i = 0; i < (int)((negative).size()) and lambda; i++) {
      long long int a = min(lambda, n - 1);
      negative[i] += a;
      lambda -= a;
    }
  }
  cout << "Possible\n";
  cout << positive.back() << " ";
  positive.pop_back();
  ans = string(ans.begin() + 1, ans.end());
  for (int i = 0; i < (int)((ans).size()); i++) {
    if (ans[i] == 'p') {
      cout << "+ " << positive.back() << " ";
      positive.pop_back();
    } else if (ans[i] == 'n') {
      cout << "- " << negative.back() << " ";
      negative.pop_back();
    }
  }
  cout << "= " << n << "\n";
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  int t = 1;
  while (t--) {
    solve();
  }
}

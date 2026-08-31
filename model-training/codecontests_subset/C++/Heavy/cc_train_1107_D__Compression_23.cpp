#include <bits/stdc++.h>
using namespace std;
bool isPrime(long long n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (long long i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
vector<long long> primes;
bool prime[10005];
void seive() {
  memset(prime, 1, sizeof(prime));
  prime[0] = 0;
  prime[1] = 0;
  for (long long i = 2; i <= 10000; i++) {
    if (prime[i] == 1) {
      for (long long j = i * i; j <= 10000; j += i) prime[j] = 0;
    }
  }
}
long long power(long long a, long long b) {
  long long ans = 1;
  while (b > 0) {
    if (b % 2 == 1) ans = (ans % 1000000007 * a % 1000000007) % 1000000007;
    a = (a * a) % 1000000007;
    b = b / 2;
  }
  return ans;
}
template <typename T>
std::string NumberToString(T Number) {
  std::ostringstream ss;
  ss << Number;
  return ss.str();
}
string cal(char c) {
  if (c == '0') return "0000";
  if (c == '1') return "0001";
  if (c == '2') return "0010";
  if (c == '3') return "0011";
  if (c == '4') return "0100";
  if (c == '5') return "0101";
  if (c == '6') return "0110";
  if (c == '7') return "0111";
  if (c == '8') return "1000";
  if (c == '9') return "1001";
  if (c == 'A') return "1010";
  if (c == 'B') return "1011";
  if (c == 'C') return "1100";
  if (c == 'D') return "1101";
  if (c == 'E') return "1110";
  if (c == 'F') return "1111";
}
void solve() {
  int n;
  cin >> n;
  int i, j, a[n + 1][n + 1], b[n + 1][n + 1];
  for (i = 0; i <= n; i++)
    for (j = 0; j <= n; j++) {
      a[i][j] = 0;
      b[i][j] = 0;
    }
  for (i = 1; i <= n; i++) {
    string s;
    cin >> s;
    int k = 1;
    for (j = 0; j < s.size(); j++) {
      string ss = cal(s[j]);
      int z = 0;
      for (int l = k; l < k + 4; l++) {
        int x = ss[z++] - '0';
        if (x == 1)
          a[i][l] = true;
        else
          a[i][l] = false;
        b[i][l] = a[i][l];
      }
      k += 4;
    }
  }
  vector<int> vec;
  for (i = n; i >= 1; i--) {
    if (n % i == 0) vec.push_back(i);
  }
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) a[i][j] += a[i][j - 1];
  }
  for (j = 1; j <= n; j++) {
    for (i = 1; i <= n; i++) b[i][j] += b[i - 1][j];
  }
  for (int p = 0; p < vec.size(); p++) {
    int x = vec[p];
    int flag = 0;
    for (i = 1; i <= n; i++) {
      for (j = x; j <= n; j += x) {
        long long sum = a[i][j] - a[i][j - x];
        if (sum == x || sum == 0)
          ;
        else {
          flag = 1;
          break;
        }
      }
      if (flag) break;
    }
    for (j = 1; j <= n; j++) {
      for (i = x; i <= n; i += x) {
        long long sum = b[i][j] - b[i - x][j];
        if (sum == x || sum == 0)
          ;
        else {
          flag = 1;
          break;
        }
      }
      if (flag) break;
    }
    if (!flag) {
      cout << x;
      return;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  bool codechef = 0;
  long long t = 1;
  if (codechef) cin >> t;
  while (t--) {
    solve();
  }
  return 0;
}

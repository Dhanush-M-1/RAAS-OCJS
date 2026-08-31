#include <bits/stdc++.h>
using namespace std;
vector<int> ar[1000001];
int vis[1000001];
int freq1[26];
int freq2[26];
bool checkPrime(int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
long long power(long long a, long long b) {
  if (b == 0) return 1;
  if (b == 1) return a;
  if (b % 2 == 1) return (power(a, b - 1) * a) % 1000000007;
  long long q = power(a, b / 2);
  return (q * q) % 1000000007;
}
bool CPT(long long n) { return !(n & (n - 1)); }
long long gcd(long long int a, long long int b) {
  if (b == 0) return a;
  return gcd(b, a % b);
}
long long lcm(int a, int b) { return (a / gcd(a, b)) * b; }
bool isSubsetSum(int set[], int n, int sum) {
  bool subset[n + 1][sum + 1];
  for (int i = 0; i <= n; i++) subset[i][0] = true;
  for (int i = 1; i <= sum; i++) subset[0][i] = false;
  for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= sum; j++) {
      if (j < set[i - 1]) subset[i][j] = subset[i - 1][j];
      if (j >= set[i - 1])
        subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
    }
  }
  return subset[n][sum];
}
bool compare(string a, string b) {
  string ab = a + b;
  string ba = b + a;
  return ab > ba;
}
bool isSubSequence(string str1, string str2, int m, int n) {
  if (m == 0) return true;
  if (n == 0) return false;
  if (str1[m - 1] == str2[n - 1])
    return isSubSequence(str1, str2, m - 1, n - 1);
  return isSubSequence(str1, str2, m, n - 1);
}
bool areEqual(int arr1[], int arr2[], int n, int m) {
  if (n != m) return false;
  int b1 = arr1[0];
  int b2 = arr2[0];
  for (int i = 1; i < n; i++) {
    b1 ^= arr1[i];
  }
  for (int i = 1; i < m; i++) {
    b2 ^= arr2[i];
  }
  int all_xor = b1 ^ b2;
  if (all_xor == 0) return true;
  return false;
}
bool isPrime(int n) {
  if (n <= 1) return false;
  if (n <= 3) return true;
  if (n % 2 == 0 || n % 3 == 0) return false;
  for (int i = 5; i * i <= n; i = i + 6)
    if (n % i == 0 || n % (i + 2) == 0) return false;
  return true;
}
int nextPrime(int N) {
  if (N <= 1) return 2;
  int prime = N;
  bool found = false;
  while (!found) {
    prime++;
    if (isPrime(prime)) found = true;
  }
  return prime;
}
void solve() {
  long long n;
  cin >> n;
  vector<int> v(n);
  for (int i = 0; i < n; i++) cin >> v[i];
  if (v[0] + v[1] <= v[n - 1]) {
    cout << 1 << " " << 2 << " " << n << "\n";
    return;
  }
  cout << -1 << "\n";
}
int main() {
  int tt;
  cin >> tt;
  while (tt--) solve();
  return 0;
}

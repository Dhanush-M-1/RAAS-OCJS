#include <bits/stdc++.h>
using namespace std;
const int fx[4][2] = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
const int fxx[9][2] = {{0, 0}, {0, 1},  {0, -1}, {1, 0},  {-1, 0},
                       {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
void subsequences(long long ar[], long long n);
long long apow(long long a, long long b);
long long bpow(long long a, long long b, long long mod);
bool dio(long long a, long long b, long long c);
bool palindrome(string s);
void sieve();
long long binarySearch(vector<long long> vec, long long n, long long x);
long long kadane(vector<long long> vec, long long n);
vector<long long> factors(long long n);
long long countBits(long long n);
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  cout.tie(0);
  long long a, b, c;
  cin >> a >> b >> c;
  long long m = a * c;
  long long n = b * c;
  cout << ceil((double)(m - n) / b);
  return 0;
}

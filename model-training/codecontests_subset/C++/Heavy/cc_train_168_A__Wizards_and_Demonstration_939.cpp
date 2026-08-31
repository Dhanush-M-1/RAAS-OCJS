#include <bits/stdc++.h>
using namespace std;
void fast() {
  std::ios_base::sync_with_stdio(0);
  cin.tie(NULL);
  cout.tie(NULL);
}
long long arr1[1000000], arr2[1000000];
string ConverToString(long long n) {
  string Result;
  stringstream convert;
  convert << n;
  Result = convert.str();
  return Result;
}
long long ConvertToInt(string s) {
  stringstream geek(s);
  long long x = 0;
  geek >> x;
  return x;
}
int main() {
  fast();
  int a, b, c, k = 0;
  cin >> a >> b >> c;
  int ans = a * c;
  if (ans % 100 != 0) {
    k++;
  }
  ans = ans / 100;
  ans = ans - b;
  ans = ans + k;
  if ((a * c / 100) - b < 0) ans = 0;
  cout << ans << "\n";
  return 0;
}

#include <bits/stdc++.h>
using namespace std;
void R__Extend_Euclid(long long a, long long b, long long &d, long long &x,
                      long long &y) {
  if (!b) {
    x = 1, y = 0, d = a;
  } else
    R__Extend_Euclid(b, a % b, d, y, x), y -= (a / b) * x;
}
template <class R>
string R__MonthName(R name) {
  string mon[15];
  mon[1] = "January";
  mon[2] = "February";
  mon[3] = "March";
  mon[4] = "April";
  mon[5] = "May";
  mon[6] = "June";
  mon[7] = "July";
  mon[8] = "August";
  mon[9] = "September";
  mon[10] = "October";
  mon[11] = "November";
  mon[12] = "December";
  return mon[name];
}
template <class R>
R R__MonthDay(R num) {
  R month[13];
  month[1] = 31;
  month[2] = 28;
  month[3] = 31;
  month[4] = 30;
  month[5] = 31;
  month[6] = 30;
  month[7] = 31;
  month[8] = 31;
  month[9] = 30;
  month[10] = 31;
  month[11] = 30;
  month[12] = 31;
  return month[num];
}
template <class R>
R R__GCD(R a, R b) {
  if (a == 0 && b == 0) return 0;
  if (a == 0) return 1;
  if (b == 0)
    return a;
  else
    return R__GCD(b, a % b);
}
template <class R>
R R__LCM(R a, R b) {
  return (a * b) / R__GCD(a, b);
}
int main() {
  int n, c, ans = 0;
  cin >> n >> c;
  vector<int> in;
  while (n--) {
    int x;
    cin >> x;
    in.push_back(x);
  }
  for (int i = 1; i < in.size(); i++) {
    int temp = in[i - 1] - in[i] - c;
    if (temp > ans) ans = temp;
  }
  cout << ans << "\n";
  return 0;
}

#include <bits/stdc++.h>
using namespace std;
vector<long long int> mn;
void M(unsigned long long int n) {
  unsigned long long int i = 2, q = sqrt((double)(n)), kol = 0;
  while (i <= q) {
    if (n % i == 0) {
      n /= i;
      kol++;
      mn.push_back(i);
    } else
      i++;
  }
}
int main() {
  long long int n;
  cin >> n;
  M(n);
  if (mn.size() == 0)
    cout << "1" << endl << "0" << endl;
  else if (mn.size() == 1)
    cout << "2" << endl;
  else if (mn[0] * mn[1] != n)
    cout << "1" << endl << mn[0] * mn[1] << endl;
  else
    cout << "2" << endl;
  return 0;
}

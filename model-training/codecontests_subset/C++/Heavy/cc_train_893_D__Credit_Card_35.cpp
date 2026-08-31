#include <bits/stdc++.h>
using namespace std;
int dx[] = {0, 0, 1, -1};
int dy[] = {1, -1, 0, 0};
int debugg = 0;
int ss = 0;
void shift() {
  if (debugg)
    for (int i = 0; i < ss; i++) cout << ".";
}
int main() {
  int n, d, flag = 1;
  cin >> n >> d;
  vector<long long int> inp(n + 1);
  vector<long long int> prefix(n + 1);
  inp[0] = 0;
  prefix[0] = 0;
  for (int i = 1; i <= n; i++) {
    cin >> inp[i];
    prefix[i] = prefix[i - 1] + inp[i];
    if (debugg) shift(), cout << " " << prefix[i];
    if (prefix[i] > d) flag = 0;
  }
  if (debugg) shift(), cout << " " << endl;
  if (flag == 0) {
    cout << -1 << endl;
    return 0;
  }
  vector<long long int> crit(n + 1);
  long long int temp = prefix[n];
  for (int i = n; i > 0; i--) {
    if (prefix[i] > temp) temp = prefix[i];
    crit[i] = temp;
  }
  for (int i = 1; i <= n; i++) {
    if (debugg) shift(), cout << " " << crit[i];
  }
  if (debugg) shift(), cout << " " << endl;
  int count = 0;
  long long int balance = 0;
  for (int i = 1; i <= n; i++) {
    if (inp[i] == 0) {
      if (balance < 0) {
        count += 1;
        long long int deposit = d - (crit[i] + balance - prefix[i - 1]);
        if (debugg) shift(), cout << " " << i << " deposited";
        if (debugg) shift(), cout << " " << crit[i];
        if (debugg) shift(), cout << " " << prefix[i - 1];
        if (debugg)
          shift(), cout << " "
                        << " : " << deposit << endl;
        balance += deposit;
        if (balance < 0) flag = 0;
      }
    }
    balance += inp[i];
    if (debugg)
      shift(),
          cout << " " << i << " balance " << balance << " " << inp[i] << endl;
  }
  if (flag == 0) {
    cout << -1 << endl;
    return 0;
  }
  cout << count << endl;
}

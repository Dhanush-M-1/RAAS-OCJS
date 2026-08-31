#include <bits/stdc++.h>
using namespace std;
int main() {
  string str;
  getline(cin, str);
  long long plus = 0, minus = 0;
  plus++;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '+') plus++;
    if (str[i] == '-') minus++;
  }
  string number;
  for (int i = str.length() - 1; i >= 0; i--) {
    if (str[i] == ' ') {
      break;
    } else
      number.push_back(str[i]);
  }
  reverse(number.begin(), number.end());
  long long n = stoi(number);
  if ((plus * n - minus) < n) {
    puts("Impossible");
    return 0;
  }
  if ((plus - n * minus) > n) {
    puts("Impossible");
    return 0;
  }
  puts("Possible");
  int now = 1;
  long long req = plus * n - minus - n;
  vector<long long> num;
  int last = 1;
  for (int i = 0; i < str.length(); i++) {
    if (str[i] == '=') break;
    if (str[i] == '?') {
      if (last == 1) {
        num.push_back(n);
      } else
        num.push_back(-1);
    } else if (str[i] == '+')
      last = 1;
    else if (str[i] == '-')
      last = 0;
  }
  for (int i = 0; i < num.size(); i++) {
    if (req == 0)
      break;
    else if (req > 0) {
      if (num[i] == n) {
        long long p = min(n - 1LL, req);
        num[i] -= p;
        req -= p;
      } else {
        long long p = min((n - 1), req);
        num[i] += (-1 * p);
        req -= p;
      }
    } else if (req < 0) {
      if (num[i] == -1) {
        long long p = max(req, -(n - 1));
        num[i] += p;
        req -= p;
      } else {
        long long p = min(-1 * req, n - 1);
        num[i] += p;
        req += p;
      }
    }
  }
  cout << num[0] << " ";
  for (int i = 1; i < num.size(); i++) {
    if (num[i] > 0) {
      cout << "+ " << num[i] << " ";
    } else
      cout << "- " << abs(num[i]) << " ";
  }
  cout << "= " << n << "\n";
}

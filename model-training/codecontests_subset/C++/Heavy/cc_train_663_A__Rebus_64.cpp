#include <bits/stdc++.h>
using namespace std;
string str;
vector<int> pos;
vector<int> neg;
int ans[110];
char ope[110];
int n;
void Init() {
  int k = 1;
  string::size_type flag;
  n = 0;
  for (string::size_type i = 0; i < str.size(); ++i) {
    if (str[i] == '=') {
      flag = i;
      break;
    }
  }
  for (string::size_type i = 0; i < flag;) {
    if (i == 0) {
      ope[k] = '+';
      pos.push_back(k++);
      if (i + 4 >= flag) break;
      i += 4;
    } else {
      if (str[i - 2] == '+') {
        ope[k] = '+';
        pos.push_back(k++);
      } else {
        ope[k] = '-';
        neg.push_back(k++);
      }
      if (i + 4 >= flag) break;
      i += 4;
    }
  }
  for (string::size_type i = flag + 2; i < str.size(); ++i)
    n = n * 10 + str[i] - '0';
}
void Slove() {
  int left, right;
  left = static_cast<int>(pos.size()) - n * static_cast<int>(neg.size());
  right = n * static_cast<int>(pos.size()) - static_cast<int>(neg.size());
  if (n < left || n > right) {
    cout << "Impossible";
    return;
  }
  for (vector<int>::size_type i = 0; i < pos.size(); ++i) ans[pos[i]] = 1;
  for (vector<int>::size_type i = 0; i < neg.size(); ++i) ans[neg[i]] = 1;
  int sum = static_cast<int>(pos.size() - neg.size());
  int s, e;
  s = e = 0;
  while (sum != n) {
    if (sum > n) {
      ans[neg[e++]] -= max(1 - n, n - sum);
      sum += max(1 - n, n - sum);
    } else {
      ans[pos[s++]] += min(n - 1, n - sum);
      sum += min(n - 1, n - sum);
    }
  }
  cout << "Possible" << endl;
  int t = static_cast<int>(pos.size() + neg.size());
  for (int i = 1; i <= t; ++i) {
    if (i == 1)
      cout << ans[1];
    else
      cout << " " << ope[i] << " " << ans[i];
  }
  cout << " = " << n << endl;
}
int main() {
  getline(cin, str);
  Init();
  Slove();
  return 0;
}

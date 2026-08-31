#include <bits/stdc++.h>
using namespace std;
string s, str;
long long mns, all, pls, nom, maxi, mini, n, sum, otn;
vector<char> v;
vector<long long> ans;
int main() {
  getline(cin, s);
  for (int i = 0; i < s.size(); i++) {
    if (s[i] == '-') mns++;
    if (s[i] == '?') all++;
    if (s[i] == '=') nom = i;
  }
  pls = all - mns;
  string str;
  str = s.substr(nom + 2, s.size() - nom - 2);
  n = atoll(str.c_str());
  maxi = n * pls - mns;
  mini = pls - mns * n;
  if (n < mini || n > maxi) {
    cout << "Impossible";
    return 0;
  }
  cout << "Possible\n";
  v.push_back('+');
  for (int i = 0; i < s.size(); i++)
    if (s[i] == '+')
      v.push_back('+');
    else if (s[i] == '-')
      v.push_back('-');
  for (int i = 0; i < v.size(); i++)
    if (v[i] == '+')
      ans.push_back(n);
    else
      ans.push_back(1);
  sum = maxi;
  for (int i = 0; i < ans.size(); i++)
    if (sum > n)
      if (v[i] == '+') {
        otn = min(n - 1, sum - n);
        ans[i] -= otn;
        sum -= otn;
      } else {
        otn = min(n - 1, sum - n);
        ans[i] += otn;
        sum -= otn;
      }
  cout << ans[0] << " ";
  for (int i = 1; i < v.size(); i++) cout << v[i] << " " << ans[i] << " ";
  cout << "= " << n;
  return 0;
}

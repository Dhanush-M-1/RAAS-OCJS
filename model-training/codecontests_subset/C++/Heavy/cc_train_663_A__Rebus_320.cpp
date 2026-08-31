#include <bits/stdc++.h>
using namespace std;
int power(int a) {
  int prod = 1;
  while (a--) prod *= 10;
  return prod;
}
int main() {
  char ch[500];
  gets(ch);
  int ln = strlen(ch);
  vector<char> v;
  v.push_back('+');
  int i, num = 0;
  for (i = 0; i < ln; i++) {
    if (ch[i] == ' ' || ch[i] == '?')
      continue;
    else if (ch[i] == '=') {
      i += 2;
      int digit = ln - i;
      int flag = 1;
      for (; i < ln; i++) num += (ch[i] - '0') * power(digit - (flag++));
    } else
      v.push_back(ch[i]);
  }
  int sum = 0, mn, mx;
  int sz = v.size();
  for (int i = 0; i < sz; i++) {
    if (v[i] == '+')
      sum += 1;
    else
      sum -= num;
  }
  mn = sum;
  sum = 0;
  for (int i = 0; i < sz; i++) {
    if (v[i] == '+')
      sum += num;
    else
      sum -= 1;
  }
  mx = sum;
  if (mn <= num && mx >= num) {
    cout << "Possible\n";
    vector<int> v1;
    for (int i = 0; i < sz; i++) {
      if (v[i] == '+')
        v1.push_back(1);
      else
        v1.push_back(num);
    }
    int barabo = num - mn;
    for (int i = 0; i < sz; i++) {
      if (barabo == 0) break;
      if (v[i] == '+') {
        int hmm = v1[i];
        if (num - v1[i] < barabo) {
          barabo -= num - hmm;
          v1[i] = num;
        } else {
          v1[i] += barabo;
          barabo = 0;
          break;
        }
      }
    }
    for (int i = 0; i < sz; i++) {
      if (barabo == 0) break;
      if (v[i] == '-') {
        int hmm = v1[i];
        if (v1[i] - 1 < barabo) {
          barabo -= v1[i] - 1;
          v1[i] = 1;
        } else {
          v1[i] -= barabo;
          break;
        }
      }
    }
    for (int i = 1; i < sz; i++) cout << v1[i - 1] << " " << v[i] << " ";
    cout << v1[sz - 1] << " = " << num;
  } else
    cout << "Impossible";
}

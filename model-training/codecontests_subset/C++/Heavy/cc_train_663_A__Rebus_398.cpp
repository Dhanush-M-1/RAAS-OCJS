#include <bits/stdc++.h>
using namespace std;
pair<int, int> solve(int positive, int negative, int number) {
  int commonValue = (number + negative) / positive;
  int mod = (number + negative) % positive;
  return make_pair(commonValue, mod);
}
int main() {
  ios_base::sync_with_stdio(0);
  int sign = 1;
  char c;
  int number;
  int positive = 1, negative = 0;
  string line;
  while (cin >> c) {
    if (c == '+') {
      sign = 1;
      positive++;
    } else if (c == '-') {
      sign = -1;
      negative++;
    } else if (c == '=') {
      cin >> number;
    }
    line += c;
  }
  bool impossible = true;
  pair<int, int> res = solve(positive, negative, number);
  if (res.first > 0 && res.first + (res.second ? 1 : 0) <= number) {
    cout << "Possible\n";
    sign = 1;
    int commonValue = res.first;
    int mod = res.second;
    for (int i = 0; i < line.size(); ++i) {
      if (line[i] == '?') {
        if (sign == 1) {
          cout << (commonValue + (mod ? 1 : 0)) << " ";
          mod = max(0, --mod);
        } else
          cout << "1 ";
      } else {
        if (line[i] == '+')
          sign = 1;
        else if (line[i] == '-')
          sign = -1;
        cout << line[i] << " ";
      }
    }
    cout << number << "\n";
    return 0;
  }
  if (negative == 0) {
    cout << "Impossible\n";
    return 0;
  }
  res = solve(negative, positive, -number);
  if (res.first > 0 && res.first + (res.second ? 1 : 0) <= number) {
    cout << "Possible\n";
    sign = 1;
    int commonValue = res.first;
    int mod = res.second;
    for (int i = 0; i < line.size(); ++i) {
      if (line[i] == '?') {
        if (sign == -1) {
          cout << (commonValue + (mod ? 1 : 0)) << " ";
          mod = max(0, --mod);
        } else
          cout << "1 ";
      } else {
        if (line[i] == '+')
          sign = 1;
        else if (line[i] == '-')
          sign = -1;
        cout << line[i] << " ";
      }
    }
    cout << number << "\n";
    return 0;
  }
  cout << "Impossible\n";
  return 0;
}

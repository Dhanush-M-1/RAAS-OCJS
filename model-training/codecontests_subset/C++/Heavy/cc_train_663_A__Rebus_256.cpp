#include <bits/stdc++.h>
using namespace std;
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  string st;
  getline(cin, st);
  long long num = 0;
  bool chk = false;
  for (int i = 0; i < st.size(); i++) {
    if (st[i] == '=') {
      chk = true;
      continue;
    }
    if (chk && st[i] >= '0' && st[i] <= '9') {
      num = num * 10 + st[i] - '0';
    }
  }
  int m = 0, p = 0;
  int q = 0;
  for (int i = 0; i < st.size(); i++) {
    if (st[i] == '-')
      m++;
    else if (st[i] == '+')
      p++;
    else if (st[i] == '?')
      q++;
  }
  if (p == 0 && m == 0) {
    cout << "Possible" << endl;
    cout << num << " = " << num << endl;
  } else if (p == 0 || (m == 0 && (p >= num))) {
    cout << "Impossible" << endl;
  } else if (m == 0) {
    cout << "Possible" << endl;
    long long fs = num - p;
    cout << fs;
    for (int i = 1; i < st.size(); i++) {
      if (st[i] == '+') cout << " + 1";
    }
    cout << " = " << num << endl;
  } else {
    if (p == m) {
      cout << "Possible" << endl;
      cout << num;
      for (int i = 1; i < st.size(); i++) {
        if (st[i] == '+' || st[i] == '-') cout << " " << st[i] << " 1";
      }
      cout << " = " << num << endl;
    } else {
      p++;
      int sum = p - m - num;
      if (sum == 0) {
        cout << "Possible" << endl;
        cout << '1';
        for (int i = 1; i < st.size(); i++) {
          if (st[i] == '+' || st[i] == '-') cout << " " << st[i] << " 1";
        }
        cout << " = " << num << endl;
      } else if (sum > 0) {
        int vage = sum / m, rem = sum % m;
        vage++;
        if (vage > num || (rem > 0 && vage + 1 > num)) {
          cout << "Impossible" << endl;
        } else {
          cout << "Possible" << endl;
          cout << '1';
          for (int i = 1; i < st.size(); i++) {
            if (st[i] == '+')
              cout << " " << st[i] << " 1";
            else if (st[i] == '-') {
              if (rem > 0) {
                cout << " " << st[i] << " " << vage + 1;
                rem--;
              } else
                cout << " " << st[i] << " " << vage;
            }
          }
          cout << " = " << num << endl;
        }
      } else {
        sum *= (-1);
        int vage = sum / p, rem = sum % p;
        vage++;
        if (vage > num || (rem > 0 && vage + 1 > num)) {
          cout << "Impossible" << endl;
        } else {
          cout << "Possible" << endl;
          if (rem > 0) {
            cout << vage + 1;
            rem--;
          } else
            cout << vage;
          for (int i = 1; i < st.size(); i++) {
            if (st[i] == '-')
              cout << " " << st[i] << " 1";
            else if (st[i] == '+') {
              if (rem > 0) {
                cout << " " << st[i] << " " << vage + 1;
                rem--;
              } else
                cout << " " << st[i] << " " << vage;
            }
          }
          cout << " = " << num << endl;
        }
      }
    }
  }
  return 0;
}

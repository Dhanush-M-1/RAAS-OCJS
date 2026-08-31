#include <bits/stdc++.h>
using namespace std;
vector<char> v;
int main() {
  int num = 0;
  int plus = 1;
  int mins = 0;
  char c = ' ';
  while (c != '=') {
    cin >> c;
    v.push_back(c);
    if (c == '-')
      mins++;
    else if (c == '+')
      plus++;
    else if (c == '?')
      num++;
  }
  int a;
  cin >> a;
  int x = a;
  a += mins;
  if (a / plus != 0) {
    if ((a / plus) <= x && a % plus == 0) {
      cout << "Possible" << endl;
      cout << a / plus << " ";
      for (int i = 1; i < v.size(); ++i) {
        if (v[i] == '+') {
          cout << "+ " << a / plus << " ";
          ++i;
        } else if (v[i] == '-') {
          cout << "- " << 1 << " ";
          ++i;
        } else if (v[i] == '=') {
          cout << "= " << x << endl;
          break;
        }
      }
    } else if ((a / plus) < x && a % plus != 0) {
      cout << "Possible" << endl;
      int h = a % plus - 1;
      cout << (a / plus) + 1 << " ";
      for (int i = 1; i < v.size(); ++i) {
        if (v[i] == '+') {
          cout << "+ ";
          if (h != 0)
            cout << (a / plus) + 1 << " ", --h;
          else
            cout << (a / plus) << " ";
          ++i;
        } else if (v[i] == '-') {
          cout << "- " << 1 << " ";
          ++i;
        } else if (v[i] == '=') {
          cout << "= " << x << endl;
          break;
        }
      }
    } else {
      cout << "Impossible" << endl;
      return 0;
    }
  } else {
    a -= mins;
    int fra = plus - a;
    if (mins != 0 && (fra / mins) <= x && fra % mins == 0) {
      cout << "Possible" << endl;
      cout << 1 << " ";
      for (int i = 1; i < v.size(); ++i) {
        if (v[i] == '+') {
          cout << "+ " << 1 << " ";
          ++i;
        } else if (v[i] == '-') {
          cout << "- " << fra / mins << " ";
          ++i;
        } else if (v[i] == '=') {
          cout << "= " << x << endl;
          break;
        }
      }
    } else if (mins != 0 && (fra / mins) < x && fra % mins != 0) {
      cout << "Possible" << endl;
      int h = fra % mins;
      cout << 1 << " ";
      for (int i = 1; i < v.size(); ++i) {
        if (v[i] == '+') {
          cout << "+ ";
          cout << 1 << " ";
          ++i;
        } else if (v[i] == '-') {
          if (h != 0) {
            cout << "- " << (fra / mins) + 1 << " ";
            --h;
          } else
            cout << "- " << (fra / mins) << " ";
          ++i;
        } else if (v[i] == '=') {
          cout << "= " << x << endl;
          break;
        }
      }
    } else {
      cout << "Impossible" << endl;
      return 0;
    }
  }
}

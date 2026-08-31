#include <bits/stdc++.h>
using namespace std;
int main() {
  string x, t;
  getline(cin, x);
  string temp = "";
  int index = -1;
  for (int i = 0; i < x.size(); ++i) {
    if (x[i] == '=') index = i;
  }
  index += 2;
  for (int i = index; i < x.size(); ++i) temp.push_back(x[i]);
  int n = stoi(temp.c_str());
  int pos = 0;
  int neg = 0;
  int i = 0;
  if (x[0] == '?') {
    ++pos;
    ++i;
  } else {
    ++neg;
    i += 2;
  }
  for (int i = 0; i < x.size(); ++i)
    if (x[i] == '+')
      ++pos;
    else if (x[i] == '-')
      ++neg;
  vector<int> ne(neg, 1);
  vector<int> po(pos, 1);
  int sum = (pos * 1) - neg;
  int j = 0, z = 0;
  bool in = false;
  while (1) {
    if (sum == n) break;
    if (sum > n) {
      if (z == neg) {
        cout << "Impossible" << endl;
        return 0;
      }
      if (ne[z] == n) {
        ++z;
        continue;
      }
      in = true;
      ++ne[z];
      sum -= 1;
    } else if (sum < n) {
      if (j == pos) {
        cout << "Impossible" << endl;
        return 0;
      }
      if (po[j] == n) {
        ++j;
        continue;
      }
      in = true;
      ++po[j];
      sum += 1;
    }
  }
  cout << "Possible" << endl;
  j = 0, z = 0;
  string last = "";
  for (int i = 0; i < x.size(); ++i) {
    if (x[i] == '-' || x[i] == '+' || i == 0) {
      if (i > 0) {
        if (x[i] == '-') {
          last.push_back(x[i]);
          stringstream ss;
          ss << ne[z++];
          last += ss.str();
          ;
        } else {
          last.push_back(x[i]);
          stringstream ss;
          ss << po[j++];
          last += ss.str();
        }
      }
      if (i == 0) {
        if (x[i] == '-') {
          last.push_back(x[i]);
          stringstream ss;
          ss << ne[z++];
          last += ss.str();
          ;
        } else {
          stringstream ss;
          ss << po[j++];
          last += ss.str();
        }
      }
    } else if (x[i] != '?')
      last.push_back(x[i]);
  }
  cout << last << endl;
  return 0;
}

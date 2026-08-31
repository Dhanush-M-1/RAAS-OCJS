#include <bits/stdc++.h>
using namespace std;
int main() {
  string str, new_str = "";
  vector<char> vect;
  cin >> str;
  for (int i = 0; i < str.size(); i++)
    if (str[i] == '1' || str[i] == '2' || str[i] == '3') vect.push_back(str[i]);
  sort(vect.begin(), vect.end());
  for (int i = 0; i < vect.size(); i++) {
    if (i != vect.size() - 1) {
      new_str += vect[i];
      new_str += '+';
    } else
      new_str += vect[i];
  }
  cout << new_str << endl;
}

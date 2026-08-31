#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  string tmp;
  cin >> n >> tmp;
  map<char, int> freq;
  for (int i = 0; i < tmp.length(); i++) freq[tmp[i]]++;
  string output = "";
  bool possible = true;
  for (map<char, int>::iterator i = freq.begin(); i != freq.end(); i++) {
    if ((*i).second % n == 0)
      for (int j = 0; j < (*i).second / n; j++) output = output + (*i).first;
    else {
      possible = false;
      break;
    }
  }
  if (possible) {
    for (int i = 0; i < n; i++) cout << output;
    cout << endl;
  } else
    cout << -1 << endl;
  return 0;
}

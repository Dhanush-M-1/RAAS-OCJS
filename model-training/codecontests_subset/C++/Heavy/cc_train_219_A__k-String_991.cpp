#include <bits/stdc++.h>
using namespace std;
int main() {
  map<char, int> myMap;
  string word;
  int k;
  cin >> k;
  cin >> word;
  for (int i = 0; i < word.size(); i++) {
    myMap[word[i]]++;
  }
  bool ok = true;
  map<char, int>::iterator iter;
  for (iter = myMap.begin(); iter != myMap.end(); iter++) {
    if (iter->second % k != 0) {
      ok = false;
      break;
    }
  }
  string temp = "";
  if (ok) {
    for (iter = myMap.begin(); iter != myMap.end(); iter++) {
      int x = iter->second / k;
      for (int i = 0; i < x; i++) temp += iter->first;
    }
    for (int i = 0; i < k; i++) cout << temp;
  } else {
    cout << "-1";
  }
  cout << endl;
  return 0;
}

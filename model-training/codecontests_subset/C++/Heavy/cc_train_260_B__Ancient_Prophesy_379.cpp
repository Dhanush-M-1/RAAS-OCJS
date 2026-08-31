#include <bits/stdc++.h>
using namespace std;
const int SIZE = 1e6;
int str2int(string str) {
  stringstream ss(str);
  int val;
  ss >> val;
  return (val);
}
string int2str(int num) {
  stringstream ss;
  string ans;
  ss << num;
  ans = ss.str();
  return ans;
}
const bool testing = 0;
const int day[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
void program() {
  string str;
  cin >> str;
  map<string, int> ans;
  for (int i = 0; i < str.length() - 9; i++) {
    string temp = str.substr(i, 10);
    bool bad = 0;
    for (int j = 0; j < 10; j++)
      if (j != 2 && j != 5)
        if (!isdigit(temp[j])) {
          bad = 1;
          break;
        }
    if (bad) continue;
    int d = str2int(temp.substr(0, 2)), m = str2int(temp.substr(3, 2)),
        y = str2int(temp.substr(6, 4));
    char ch1 = temp[2], ch2 = temp[5];
    if (ch1 == '-' && ch2 == '-') {
      if (y > 2012 && y < 2016)
        if (m >= 1 && m <= 12)
          if (d >= 1 && d <= day[m])
            if (ans.find(temp) != ans.end())
              ans[temp]++;
            else
              ans[temp] = 1;
    }
  }
  int max = 0;
  auto mymax = ans.begin();
  for (auto it = ans.begin(); it != ans.end(); it++) {
    if (it->second > max) max = it->second, mymax = it;
  }
  cout << mymax->first;
}
int main() {
  if (!testing) {
    program();
    return 0;
  }
  FILE* fin = NULL;
  fin = fopen("in.txt", "w+");
  fprintf(fin, "15-1--201315-1--201301-01-2013\n");
  fclose(fin);
  freopen("in.txt", "r", stdin);
  printf("test case(1) => expected : \n");
  printf("13-12-2013");
  printf("test case(1) => founded  : \n");
  program();
  return 0;
}

#include <iostream>
#include <string>
using namespace std;

int main(void){
  int n;
  string num;
  cin >> n;
  for(int i = 0; i < n; i++){
    int cnt = 0;
    cin >> num;
    while(num.size() > 1){
      int maxn = 0;
      for(int i = 0; i < num.size() - 1; i++){
        string op1(num, i + 1, num.size() - i), op2(num, 0, i + 1);
        int n = stoi(op1) * stoi(op2);
        if(n > maxn) maxn = n;
      }
      num = to_string(maxn);
      cnt++;
      if(cnt > 1000000) break;
    }
    if(cnt <= 1000000) cout << cnt << endl;
    else cout << -1 << endl;
  }
  return 0;
}
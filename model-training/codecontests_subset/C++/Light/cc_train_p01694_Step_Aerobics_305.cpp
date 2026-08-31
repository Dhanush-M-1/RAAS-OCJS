#include <iostream>
#include <string>
using namespace std;

int main(){

  int n;
  string str;

  while(cin >> n, n){
    int cnt = 0;
    bool next = true;
    bool l = false, r = false;
    for(int i = 0; i < n; i++){
      cin >> str;
      if(str == "lu") l = true;
      if(str == "ru") r = true;
      if(str == "ld") l = false;
      if(str == "rd") r = false;
      if(l == next && r == next){
        cnt++;
        next = !next;
      }
    }
    cout << cnt << endl;
  }
  return 0;
}

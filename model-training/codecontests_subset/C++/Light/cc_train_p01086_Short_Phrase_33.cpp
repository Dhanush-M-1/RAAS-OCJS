#include<iostream>
#include <vector>
using namespace std;

int main(){
  while (1){
    int n;
    cin >> n;
    if(n==0) break;

    vector<string> words(n+1);
    for(int i=1; i<=n; i++){
      cin >> words[i];
    }
    
    for(int i=1; i<n+1; i++){
      bool flag = false;
      int tanka[5]={5,7,5,7,7};
      int now = 0;
      for(int j=0; j+i<n+1; j++){
        int len=words[i+j].length();
        if(tanka[now]-len>=0){
          tanka[now] -= len;
        }else{
          break;
        }
        if(tanka[now]==0){
          now++;
        }
        if(now==5){
          cout << i << endl;
          flag = true;
          break;
        }
      }
      if(flag){
        break;
      }
        
    }
    
  }
  return 0;
}
#include<iostream>
#include<string>
using namespace std;

int main(){
 while(true){
  int n;
  cin >> n;

  if(n==0) break;

  int len[n];
  for(int i=0; i<n; i++){
   string w;
   cin >> w;
   len[i] = w.size();
  }

  for(int i=0; i<n; i++){
   bool flag = false;
   int sta = 0; //区切り
   int sum = 0; //文字数の合計

   for(int j=i; j<n; j++){
    sum = sum + len[j];
    
    if(sum==5 || sum==12 || sum==17 || sum==24 || sum==31){
     sta++;
    }

    if(sta==5){
     flag = true;
     break;
    //}else if(sum>=31){
    // break;
    }
   }

   if(flag){
    cout << i+1 << endl;
    break;
   }
  }
 }

 return 0;
}

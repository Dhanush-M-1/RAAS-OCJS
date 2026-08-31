#include<iostream>
#include<string>
using namespace std;
int main(){
  int n,m,s,max,cnt;
  string  str,str1;
  cin>>n;
  for(int i=0;i<n;i++){
     cin>>str;
     cnt=0;
     while(1){
       if(str.size()==1) break;
       str1=str[0],max=0;
     for(int j=0;j<str.size()-1;j++){
       if(j>0) str1+=str[j];
       m=stoi(str1),s=stoi(&str[j+1]);
       if(max<m*s) max=m*s;
     }
     str=to_string(max),cnt++;
     }
     cout<<cnt<<endl;    
  }
  return 0;
}
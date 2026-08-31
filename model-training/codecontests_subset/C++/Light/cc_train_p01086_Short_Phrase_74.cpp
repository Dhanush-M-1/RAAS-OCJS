#include<bits/stdc++.h>
using namespace std;
void format(int a[]){
  for(int i=0;i<5;i++){
    if(i==0||i==2)
      a[i]=5;
    else
      a[i]=7;
  }
}
int main(){
  int n;
  while(cin>>n,n!=0){
    string word[n];
    for(int i=0;i<n;i++)
      cin>>word[i];
    int cnt[n];
    format(cnt);
    for(int j=0;j<n;j++){
      int flag=0;
      format(cnt);
      int pointer=0;
      for(int i=j;i<n;i++){
	cnt[pointer]-=word[i].size();
	if(cnt[pointer]<0)
	  break;
	else if(cnt[pointer]==0&&pointer==4){
	  cout<<j+1<<endl;flag=1;break;
	}else if(cnt[pointer]==0)
	  pointer++;
      }
      if(flag==1)
	break;
    }
  }
  return 0;
}
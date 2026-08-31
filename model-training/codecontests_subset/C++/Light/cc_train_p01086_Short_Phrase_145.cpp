#include<iostream>
#include<string>
#define loop(i,a,b) for(int i=a;i<b;i++)
#define rep(i,a) loop(i,0,a)
using namespace std;

int main(){
	int n;
	while(cin>>n,n){
		string s[n];
		int num[n];
		rep(i,n)cin>>s[i];
		rep(i,n)num[i]=s[i].size();
		rep(i,n){
			int check=0,sum=0;
			for(int j=i;sum<=31;j++){
				sum+=num[j];
				if(sum==5)check|=1;
				else if(sum==12)check|=(1<<1);
				else if(sum==17)check|=(1<<2);
				else if(sum==24)check|=(1<<3);
				else if(sum==31)check|=(1<<4);
			}
			if(check==(31)){
				cout<<i+1<<endl;
				break;
			}
		}
	}
	return 0;

}
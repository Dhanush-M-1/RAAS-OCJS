#include<iostream>
#include<cstring>
using namespace std;

int num[6]={5,7,5,7,7};
int n;
int t[55];

bool check(int a,int s=0,int i=0){
	if(s>num[i])return false;
	if(s==num[i])i++,s=0;
	if(i==5)return true;
	if(a>=n)return false;
	return check(a+1,s+t[a],i);
}

int main(){
	int i,j,k;
	int a,b,c;
	char ca[15];
	while(cin>>n){
		if(!n)break;
		for(i=0;i<n;i++){
			cin>>ca;
			t[i]=strlen(ca);
		}
		for(i=0;i<n;i++){
			if(check(i)){
				cout<<i+1<<endl;
				break;
			}
		}
	}
}


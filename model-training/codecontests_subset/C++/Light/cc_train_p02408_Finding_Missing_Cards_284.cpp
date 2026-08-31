#include<iostream>
using namespace std;

int main(){
	int n,i;
	int shcd[52];
	string mark[5]={"S","H","C","D"};
	cin>>n;
	string str[n];
	int a[n];
	for(i=0; i<n; i++){
		cin>>str[i]>>a[i];
	}
	for(i=0; i<52; i++){
		shcd[i]=i%13+1;
	}
	for(i=0; i<n; i++){
		if(str[i]=="S"){
			shcd[a[i]-1]=0;
		}else if(str[i]=="H"){
			shcd[a[i]+12]=0;
		}else if(str[i]=="C"){
			shcd[a[i]+25]=0;
		}else{
			shcd[a[i]+38]=0;
		}
	}
	int m=0;
	for(i=0; i<52; i++){
		if(shcd[i]!=0) cout<<mark[m]<<" "<<shcd[i]<<"\n";
		if((i+1)%13==0) m++;
	}
	return 0;
}

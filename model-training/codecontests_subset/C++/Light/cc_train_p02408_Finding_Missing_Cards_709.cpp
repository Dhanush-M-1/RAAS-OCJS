#include<bits/stdc++.h>
using namespace std;

bool s[13]={},h[13]={},c[13]={},d[13]={};

int main(){
	int a,b;
	char c1;
	cin>>a;
	for (int i=0;i<a;i++){
		cin>>c1>>b;
		if (c1=='S')s[b-1]=1;
		if (c1=='H')h[b-1]=1;
		if (c1=='C')c[b-1]=1;
		if (c1=='D')d[b-1]=1;
	}
		for (int i=0;i<13;i++){
			if (s[i]==0)cout<<"S "<<i+1<<endl;
		}
		for (int i=0;i<13;i++){
			if (h[i]==0)cout<<"H "<<i+1<<endl;
		}
		for (int i=0;i<13;i++){
			if (c[i]==0)cout<<"C "<<i+1<<endl;
		}
		for (int i=0;i<13;i++){
			if (d[i]==0)cout<<"D "<<i+1<<endl;
		}
		//cout<<endl;
}

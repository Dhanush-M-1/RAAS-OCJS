#define _USE_MATH_DEFINES
#include<stdio.h>
#include<string>
#include<iostream>
#include<cctype>
#include<cstdio>
#include<vector>
#include<stack>
#include <algorithm>
#include<math.h>
#include<set>
#include<map>
#include<iomanip>
using namespace std;



int main(){
	
int n;
while(1){
	cin>>n;
	if(!n)break;
	int p[50]={};;
	for(int i=0;i<n;i++){
		string y;
		cin>>y;
		p[i]=y.size();
	}
	
	for(int i=0;i<n;i++){
		bool a=0,b=0,c=0,d=0,e=0;
		int r=0;
		for(int j=i;j<n;j++){
			r+=p[j];
			if(!a&&r==5)a++;
			if(!a&&r>5)break;
			if(r==12)b++;
			if(!b&&r>12)break;
			if(r==17)c++;
			if(!c&&r>17)break;
			if(r==24)d++;
			if(!d&&r>24)break;
			if(r==31)e++;
			if(!e&&r>31)break;
			if(a&&b&&c&&d&&e){
				cout<<i+1<<endl;
				break;
			}
		}
		if(a&&b&&c&&d&&e){
				
				break;
			}
	}

}

	return 0;
}
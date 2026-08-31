#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;
using ll = long long;
int main(void){
	while(1){
		int n,sum,flag;
		string str;
		cin >> n;
		if(n==0)	break;
		vector<int> len(n);
		for(int i=0;i<n;i++){
				cin >> str;
				len[i] = str.size();
		}
		for(int i=0;i<n;i++){
			sum=0;
			flag=0;
			for(int j=i;(j<n&&sum<=7);j++){
				sum+=len[j];
				if(sum==5&&flag==0){
					flag=1;
					sum=0;
				}
				if(sum==7&&flag==1){
					flag=2;
					sum=0;
				}
				if(sum==5&&flag==2){
					flag=3;
					sum=0;
				}
				if(sum==7&&flag==3){
					flag=4;
					sum=0;
				}
				if(sum==7&&flag==4){
					cout << i+1 << endl;
					flag=5;
				}
			}
			if(flag==5)	break;
		}
	}
	return 0;
}

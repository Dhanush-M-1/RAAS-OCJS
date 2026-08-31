#include <iostream>
using namespace std;
int main(){
	int num;
	int n[100]={0};
	while(cin >> num){
		if(num==0)break;
		for(int i=0;i<num;++i) cin >> n[i];
		int count=0;
		for(int i=0;i<num-1;++i){
			for(int j=num-1;j>i;--j){
				if(n[j]<n[j-1]){
					int tmp = n[j];
					n[j]=n[j-1];
					n[j-1]=tmp;
					++count;
				}
			}
		}
		cout << count << "\n";
	}
	return 0;
}
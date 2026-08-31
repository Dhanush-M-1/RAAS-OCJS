#include <iostream>
#include <vector>
#include<algorithm>
#include<iomanip>
#include<queue>
using namespace std;
#define rep(i,n) for(int i=1;i<=(int)(n);i++)
#define Rep(i,n) for(int i=0;i<=(int)(n-1);i++)

int inf=1000200000;

int max(int N){
	int max =0;
	for(int i=10; N/i>0;i=i*10){
		int kouho;
		kouho = (N/i)*(N-(N/i)*i);
		if(kouho>max){
			max = kouho;
		}
	}
	return max;
}


int main() {
	int Q;
	cin>>Q;
	Rep(i,Q){
		int N;
		cin>>N;
		int count = 0;
		rep(i,inf){
			if(N<=9){
				cout<<count<<endl;
				break;
			}
			else if(i >= inf-1){
				cout<<-1<<endl;
				break;
			}
			else{
				N =max(N);
				count++;
			}
		}
	}

	return 0;
}


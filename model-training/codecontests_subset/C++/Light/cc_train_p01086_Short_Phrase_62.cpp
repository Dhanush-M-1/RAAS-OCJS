#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <string.h>

int main (){


  int n,ans = 0,count = 0,temp;
  int cc[5],ku;
  cc[0] = 5;
  cc[1] = 7;
  cc[2] = 5;
  cc[3] = 7;
  cc[4] = 7;

  char moji[40][10];
  while(1){
    scanf("%d",&n);
    if(n == 0) break;
    for(int i = 0;i < n;i++){
      scanf("%s",&moji[i]);
      //printf("%s ",moji[i]);fflush(0);
    }
	ans = 0;
	count = 0;
	temp = 0;
	ku = 0;
	while(1){
		temp += strlen(moji[ans+count]);
		//printf("%d",temp);
		if(cc[ku] == temp){
			if(ku == 4){
				break;
			}
			temp = 0;
			ku++;
		}
		else if(cc[ku] < temp){
			ku = 0;
			temp = 0;
			ans++;
			count = 0;
			continue;
		}
		count++;
	}
    printf("%d\n",ans+1);
  }
  return 0;
}